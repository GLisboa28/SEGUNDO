/* Guilherme Lisboa
Assignment week 12
Dice Roller Stats
 */
package assignmenta7;

import java.util.Arrays;
import java.util.Random;

public class Assignmenta7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        class DiceRoller {

            private int[] rollseries;
            private Indicator[] statIndicators;

            public DiceRoller(int n) {
                rollseries = new int[n];
                statIndicators = new Indicator[13];
                for (int i = 0; i < 13; i++) {
                    statIndicators[i] = new Indicator(i);
                }
                for (int i = 0; i < n; i++) {
                    rollseries[i] = roll();
                }
                collectStatistics();
            }

            public int roll() {
                Random rand = new Random();
                int num1 = rand.ints(1, 7).findFirst().getAsInt();
                int num2 = rand.ints(1, 7).findFirst().getAsInt();
                return num1 + num2;
            }

            public void collectStatistics() {
                for (int i = 0; i < rollseries.length; i++) {
                    statIndicators[rollseries[i]].increment();
                }
            }

            public void printReport() {
                Arrays.sort(statIndicators);
                int total = 0;
                for (int i = 0; i < statIndicators.length; i++) {
                    total += statIndicators[i].getDicePairCount();
                }
                System.out.println("------------------------");
                System.out.println("dice");
                System.out.println("pair   roll");
                System.out.println("total  count   percent");
                System.out.println("-----  -----   ---------");
                for (int i = 0; i < statIndicators.length; i++) {
                    if (statIndicators[i].getDicePairCount() != 0) {
                        double p = (statIndicators[i].getDicePairCount() * 100) / (total * 1.0);
                        System.out.printf("%-5d  %-5d   %.2f%%\n", statIndicators[i].getDicePairTotal(),
                                statIndicators[i].getDicePairCount(), p);
                    }
                }

            }

        }
    }

}
