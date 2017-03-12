/**
 * Created by Ilua on 05.03.2017.
 */
public class testClass {

    //Wix - 3
/*
    public static void main(String[] args)
    {
        testClass t=new testClass();
        int[] A=new int[9];
        A[0] = 1;    A[1] = 2;    A[2] = 4;
        A[3] = 7;    A[4] = 6;    A[5] = 6;
        A[6] = 6;    A[7] = 2;    A[8] = 0;

        System.out.println(t.solution(A));
        System.out.println(t.counter1);
        System.out.println(t.counter2);
        System.out.println(t.counter3);


    }

    int counter1=0;
    int counter2=0;
    int counter3=0;

    public int solution(int[] A) {

        if (A.length>1000000||A.length<0) return -1;
        for(int i=0;i<A.length;i++)
        {
            if(i<-1000000||i>1000000) continue;
            recursiveСheck1(i, A);
            recursiveСheck2(i, A);
            recursiveСheck3(i, A);
        }
        return counter1+counter2+counter3;
    }
    private void recursiveСheck1(int i, int[] A)
    {
        if(i+1<A.length && A[i]<A[i+1]) {
            counter1++;
            recursiveСheck1(i+1, A);
        }
    }
    private void recursiveСheck2(int i, int[] A)
    {
        if(i+1<A.length && A[i]==A[i+1]) {
            counter2++;
            recursiveСheck2(i+1, A);
        }
    }
    private void recursiveСheck3(int i, int[] A)
    {
        if(i+1<A.length && A[i]>A[i+1]) {
            counter3++;
            recursiveСheck3(i+1, A);
        }
    }
*/

    //WIX - 2
/*
    public static void main(String[] args)
    {
        testClass t=new testClass();
        Tree tree=new Tree(4);
        //tree.l=new Tree(5);
        //tree.l.l=new Tree(4);
        //tree.l.l.l=new Tree(5);
        tree.r=new Tree(6);
        tree.r.l=new Tree(1);
        tree.r.r=new Tree(6);



        System.out.println("result: "+t.solution(tree));
        System.out.println("set size: " +set.size());
    }

    private static int max=0;
    private static HashSet<Integer> set=new HashSet<>();

    public int solution(Tree T) {
        walkTree(T);
        return max;
    }
    private void walkTree(Tree T)
    {
        if(set.contains(T.x)) {
            max=max<set.size()?set.size():max;
            return;
        }
        else set.add(T.x);
        if(T.l!=null) {
            walkTree(T.l);
        }
        else max=max<set.size()?set.size():max;
        if(T.r!=null) {
            walkTree(T.r);
        }
        else max=max<set.size()?set.size():max;
        set.remove(T.x);
    }

    static class Tree {
        public int x;
        public Tree l;
        public Tree r;

        public Tree(int x) {
            this.x = x;
        }
    }
*/

    //WIX - 1
/*
    public static void main(String[] args)
    {
        testClass t=new testClass();
        System.out.println(t.solution(53, 1953786));
    }

        public int solution(int A, int B) {
            int result=-1;
            int from=0;
            int to=1000000000;
            if(A>=from && A<to && B>=from && B<to) {
                String numberStringB = String.valueOf(B);
                result = numberStringB.indexOf(String.valueOf(A));
            }
            return result;
        }
*/








/*
    public static void main(String[] args)
    {
        BinaryTree<Integer> tree=testClass.initIntegerTree();
        Iterator<Integer> iterator=tree.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    private static BinaryTree<Integer> initIntegerTree()
    {
        BinaryTree<Integer> tree=new BinaryTree<>();
        tree.add(1);
        tree.add(10);
        tree.add(15);
        tree.add(12);
        tree.add(11);
        return tree;
    }
    */
/*
    public static void main(String[] args)
    {
        //initTree
        System.out.println("---------------------------------------------------------------");
        System.out.println("Init: ");
        long startInit=System.currentTimeMillis();
        System.out.println("Used memory: "+Runtime.getRuntime().freeMemory()/1024/1024+" mb");
        System.out.println("---------------------------------------------------------------");
        //---------------------------------------------------------------------------------//
        testClass testClass=new testClass();
        BinaryTree<String> tree=testClass.initTree();
        HashMap<String, String> blackList=testClass.initBlackList();
        System.out.println("Tree size: "+tree.size());
        System.out.println("---------------------------------------------------------------");
        //---------------------------------------------------------------------------------//
        long stopInit=System.currentTimeMillis();
        System.out.println("Time: "+((stopInit-startInit))+" milliseconds");
        System.out.println("Used memory: "+Runtime.getRuntime().freeMemory()/1024/1024+" mb");
        System.out.println("---------------------------------------------------------------");
        System.out.println();

        //decision 1
        System.out.println("---------------------------------------------------------------");
        System.out.println("Decision 1: ");
        startInit=System.currentTimeMillis();
        System.out.println("Used memory: "+Runtime.getRuntime().freeMemory()/1024/1024+" mb");
        System.out.println("---------------------------------------------------------------");
        //---------------------------------------------------------------------------------//
        int counter=0;
        for(Map.Entry<String,String> entry:blackList.entrySet())
        {
            if(tree.contains(tree.root, entry.getKey().split("from:")[1]) && tree.contains(tree.root,entry.getValue().split("to:")[1])) counter++;
        }

        System.out.println(counter);
        //---------------------------------------------------------------------------------//
        System.out.println("---------------------------------------------------------------");
        stopInit=System.currentTimeMillis();
        System.out.println("Time: "+((stopInit-startInit))+" milliseconds");
        System.out.println("Used memory: "+Runtime.getRuntime().freeMemory()/1024/1024+" mb");
        System.out.println("---------------------------------------------------------------");
        System.out.println();

        //decision 2
        System.out.println("---------------------------------------------------------------");
        System.out.println("Decision 2: ");
        startInit=System.currentTimeMillis();
        System.out.println("Used memory: "+Runtime.getRuntime().freeMemory()/1024/1024+" mb");
        System.out.println("---------------------------------------------------------------");
        //---------------------------------------------------------------------------------//
        counter=0;

        for(Map.Entry<String,String> entry:blackList.entrySet())
        {
            if(tree.checkEmail(entry.getKey().split("from:")[1],entry.getValue().split("to:")[1])) counter++;
        }

        System.out.println(counter);
        //---------------------------------------------------------------------------------//
        System.out.println("---------------------------------------------------------------");
        stopInit=System.currentTimeMillis();
        System.out.println("Time: "+((stopInit-startInit))+" milliseconds");
        System.out.println("Used memory: "+Runtime.getRuntime().freeMemory()/1024/1024+" mb");
        System.out.println("---------------------------------------------------------------");
        System.out.println();
    }

    private HashMap<String,String> initBlackList() {
        HashMap<String,String> blackList=new HashMap<>();
        //int records=1000000;
        int records=10000;
        int length=7;
        for(int i=0;i<records;i++) {
            blackList.put("from:" + getRandomString(length), "to:" + getRandomString(length));
        }
        blackList.put("from:me", "to:him");
        return blackList;
    }

    private BinaryTree<String> initTree()
    {
        BinaryTree<String> tree=new BinaryTree<>();
        int records=5000000;
        int length=7;
        for(int i=0;i<records;i++)
        {
            tree.add(getRandomString(length));
        }
        tree.add("me");
        tree.add("him");
        return tree;
    }

    public static String getRandomString(int length)
    {
        String randomStr = UUID.randomUUID().toString();
        while(randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, length);
    }
*/
}
