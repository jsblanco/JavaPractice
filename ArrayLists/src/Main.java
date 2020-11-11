import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

/*GroceryList groceries = new GroceryList();

    ArrayList list = new ArrayList();
    list.add( "popo");
    list.add(0,"pepe");
    System.out.println(list);
*/


        LinkedList<String> EmperorsChildrenList = new LinkedList<String>();
        addInOrder(EmperorsChildrenList, "Noise marines");
        addInOrder(EmperorsChildrenList, "Sonic dreandoughts");
        addInOrder(EmperorsChildrenList, "Chaos Terminators");
        addInOrder(EmperorsChildrenList, "Chaos Havocs");
        addInOrder(EmperorsChildrenList, "Chaos Havocs");
        addInOrder(EmperorsChildrenList, "Chaos Havocs");
        addInOrder(EmperorsChildrenList, "Chaos Havocs");
        addInOrder(EmperorsChildrenList, "Chaos Havocs");
        addInOrder(EmperorsChildrenList, "Obliterators");
        EmperorsChildrenList.add(0, "Primaris Marines");
        EmperorsChildrenList.add("Inquisitors");
        EmperorsChildrenList.remove(0);
        EmperorsChildrenList.remove("Inquisitors");
        addInOrder(EmperorsChildrenList, "Chaos bikers");
        addInOrder(EmperorsChildrenList, "Dark Apostle");
        addInOrder(EmperorsChildrenList, "Warp talons");
        addInOrder(EmperorsChildrenList, "Possessed Space Marines");

        //printList(EmperorsChildrenList);
        checkLegion(EmperorsChildrenList);
    }


    public static boolean addInOrder(LinkedList<String> list, String newUnit) {
        ListIterator<String> stringListIterator = (ListIterator<String>) list.iterator();
        while (stringListIterator.hasNext()) {
            int compare = stringListIterator.next().compareTo(newUnit);
            if (compare == 0) {
                System.out.println(newUnit + " are already a part of the Legion!");
                return false;
            } else if (compare > 0) {
                stringListIterator.previous();
                stringListIterator.add(newUnit);
                return true;
            } else if (compare < 0) {
                //No need to do anything
            }
        }
        //Si el código llega hasta aquí es que no ha conseguido encontrar el sitio
        // donde colocarla, pero no está en la lista, así que la añadimos al final.
        stringListIterator.add(newUnit);
        return true;
    }


    public static void printLegion(LinkedList list) {
        Iterator<String> i = list.iterator();
        System.out.println("The Emperor's Children Legion is comprised of:");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("For Fulgrim!!");
    }

    private static void checkLegion(LinkedList<String> list) {
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        boolean forward = true;
        ListIterator<String> iterator = list.listIterator();

        if (list.isEmpty()) {
            System.out.println("This Legion is currently empty");
            return;
        } else {
            System.out.println("The Legion is comprised of: "+iterator.next());
            printMenu();
        }

        while (!end) {

            int index = scanner.nextInt();
            scanner.nextLine();
            switch (index) {
                case 0:
                    System.out.println("Finished checking the Legion");
                    end = true;
                    break;
                case 1:
                    if (!forward){
                        if (iterator.hasNext()){
                            iterator.next();
                        }
                        forward=true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    } else {
                        System.out.println("That was the end of the Legion list");
                        forward=false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                        forward=false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    } else {
                        System.out.println("That was the start of the Legion list");
                        forward=true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }

    }


    private static void printMenu(){
        System.out.println("Available actions:");
        System.out.println("Press 0 to quit.\n Press 1 to move to the next unit.\n Press 2 to move to the previous unit.\n Press 3 to see this menu again.");
    }

}
