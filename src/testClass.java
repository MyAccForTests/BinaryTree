import java.util.*;

/**
 * Created by Ilua on 05.03.2017.
 */
public class testClass {

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
}
