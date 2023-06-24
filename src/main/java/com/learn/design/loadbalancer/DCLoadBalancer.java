package com.learn.design.loadbalancer;


import java.util.*;

class DCLoadBalancer {
    private Queue<Machine> machines;

    private Map<Integer, Integer> appIdToMachineId;

    private Map<Integer, Machine> machineIdToMachine;

    public DCLoadBalancer() {
        this.machines = new PriorityQueue<>((m1, m2) -> {
            if (m1.capacity < m2.capacity) {
                return 1;
            } else if (m1.capacity > m2.capacity) {
                return -1;
            } else {
                return m2.id < m1.id ? 1 : -1;
            }
        });
        this.appIdToMachineId =  new HashMap<>();
        this.machineIdToMachine = new HashMap<>();
    }

    static class Machine {
        int id;
        int capacity;

        Map<Integer, App> apps;

        List<Integer> appList;

        public Machine(int id, int capacity) {
            this.id = id;
            this.capacity = capacity;

            this.apps = new HashMap();

            appList = new ArrayList<>();
        }

        boolean addApplication(int appId, int load) {
            if (load > capacity) {
                return false;
            }

            apps.put(appId, new App(appId, load));
            this.capacity -= load;

            appList.add(appId);
            return true;
        }

        boolean stopApplication(int appId) {
            if (apps.containsKey(appId)) {
                App app = apps.remove(appId);
                this.capacity += app.load;

                apps.remove(appId);
                appList.remove(new Integer(appId));
                return true;
            }

            return false;
        }

        List<Integer> getApplications() {
            return appList;
        }

        @Override
        public String toString() {
            return "id: "+this.id+ " capacity : "+this.capacity;
        }
    }

    static class App {
        int id;
        int load;

        public App(int id, int load) {
            this.id = id;
            this.load = load;
        }
    }

    public static void main(String[] args) {

        DCLoadBalancer lb = new DCLoadBalancer();

//        lb.addMachine(1, 1);
//        lb.addMachine(2, 10);
//        lb.addMachine(3, 10);
//        lb.addMachine(4, 15);
//
//
//        System.out.println(lb.machines);
//
//        lb.addApplication(1, 3);
//        lb.addApplication(2, 11);
//        System.out.println(lb.addApplication(3, 6));
//        lb.addApplication(4, 5);
//
//        System.out.println(lb.getApplications(2));
//
//        lb.addMachine(5, 10);
//
//        System.out.println(lb.machines);
//
//        lb.addApplication(5, 5);
//
//        System.out.println(lb.machines);
//
//        lb.stopApplication(3);
//
//        System.out.println(lb.machines);

        lb.addMachine(73314, 38096);

        System.out.println(lb.getApplications(73314));

        System.out.println(lb.machines);

        System.out.println(lb.addApplication(73314, 46083));

        System.out.println(lb.machines);




    }

    void addMachine(int machineId, int capacity) {
        if (!machines.contains(machineId)) {
            Machine machine = new Machine(machineId, capacity);

            machineIdToMachine.put(machineId, machine);

            machines.add(machine);
        }
    }

    void removeMachine(int machineId) {
        Machine machine = machineIdToMachine.get(machineId);

        machineIdToMachine.remove(machineId);
        machines.remove(machine);

        List<Integer> appIds = machine.appList;

        for (int id : appIds) {
            App app = machine.apps.get(id);
            this.addApplication(app.id, app.load);
        }

    }

    int addApplication(int appId, int loadUse) {
        Machine machine = machines.poll();

        if (machine == null || machine.capacity < loadUse) {
            machines.add(machine);
            return -1;
        }

        machine.addApplication(appId, loadUse);
        machines.add(machine);

        appIdToMachineId.put(appId, machine.id);

        return machine.id;
    }

    void stopApplication(int appId) {

        if (appIdToMachineId.get(appId) != null) {
            int machineId = appIdToMachineId.get(new Integer(appId));

            Machine machine = machineIdToMachine.get(machineId);

            machines.remove(machine);

            machine.stopApplication(appId);

            appIdToMachineId.remove(appId);

            machines.add(machine);
        }
    }

    List<Integer> getApplications(int machineId) {
        Machine machine = machineIdToMachine.get(machineId);

        return machine.getApplications();
    }
}
