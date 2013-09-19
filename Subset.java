public class Subset {
    
    public Subset() {
    }
    
    private Deque myDeque;
    
    public static void main(String args[]) {
        System.out.println("In program");
        
        int numElems = args.length - 1;
        
        int k = Integer.parseInt(args[0]);
        String N;
        
        System.out.println("k = " + k);

        
        // This type of class object creation is necessary to avoid unchecked call warning
        // If we create a regular class, it'll give warning in the addFirst() call below
        Deque<String> myDeque = new Deque<String>();
        
       // for (int i=1; i<numElems; i++) {
        while (!StdIn.isEmpty()) {
            N = StdIn.readString();
            System.out.println("N = " + N);
            myDeque.addFirst(N);
        }
        
        for (int i=0; i<k; i++) {
            String a = myDeque.removeLast();
            String b = myDeque.removeFirst();
            System.out.println("a=" + a);
            System.out.println("b=" + b);
        }
        
    }
}
        