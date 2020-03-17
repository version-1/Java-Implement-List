public class Driver {
  public static void main(String[] args) {
     MyLinkedList<Integer> list = new MyLinkedList<Integer>();
     list.add(0);
     list.add(1);
     list.add(2);
     list.add(3);

     list.add(0, 10);

     System.out.println(list);
     System.out.println(list.size());
  }
}