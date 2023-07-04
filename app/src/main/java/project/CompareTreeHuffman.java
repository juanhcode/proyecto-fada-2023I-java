package project;

import java.util.Comparator;

public class CompareTreeHuffman implements Comparator<HuffmanBinaryTree> {


    @Override
    public int compare(HuffmanBinaryTree nodo1, HuffmanBinaryTree nodo2) {
        return nodo1.getNumberKey() - nodo2.getNumberKey();
    }
}
