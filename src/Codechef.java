import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    static class Node{
        int data;
        Node parent = null;
        ArrayList<Node> arrayList;

        Node(int data) {
            this.data = data;
            this.arrayList = new ArrayList<>();
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public ArrayList<Node> getArrayList() {
            return arrayList;
        }

        public void setArrayList(ArrayList<Node> arrayList) {
            this.arrayList = arrayList;
        }
    }

    static class GenTree{
        Node root;

        GenTree(Node root) {
            this.root=root;
        }

        Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }

        void print(Node node){
            System.out.println(node.getData());

            Iterator<Node> iterator= node.getArrayList().iterator();

            while(iterator.hasNext()){
                print(iterator.next());
            }
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        int[] nodes={0,5,10,15,20,25};
        int[][] edges={{1,2},{1,3},{2,4},{2,5},{5,6}};

        GenTree genTree = new GenTree(new Node(nodes[0]));

        ArrayList<Node> list=new ArrayList<>();
        list.add(genTree.getRoot());

        for(int i=1;i<=5;i++){
            list.add(new Node(nodes[i]));
        }

        for(int i=0;i<=4;i++){
            list.get(edges[i][0] - 1).getArrayList().add(list.get(edges[i][1] - 1));
        }

        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            Iterator<Node> iterator= list.get(i).getArrayList().iterator();
            while(iterator.hasNext()){
                System.out.println(i+" "+iterator.next().getData());
            }
        }

        genTree.print(genTree.getRoot());
    }
}
