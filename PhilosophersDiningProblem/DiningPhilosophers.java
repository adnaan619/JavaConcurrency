package PhilosophersDiningProblem;

public class DiningPhilosophers {
    public static void main(String[] args) {
        final int NUM_PHILOSOPHERS = 5;
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        Object[] forks = new Object[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++){
            forks[i] = new Object();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];

            // To avoid deadlock, we ensure that the last philosopher picks up the right fork first
            if (i == NUM_PHILOSOPHERS - 1) {
                philosophers[i] = new Philosopher(i, rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(i, leftFork, rightFork);
            }

            new Thread(philosophers[i], "Philosopher-" + i).start();
        }
    }
}
