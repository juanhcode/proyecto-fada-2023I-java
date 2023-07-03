/**
 * Esta clase verifica la estructura del árbol de Huffman.
 * @Author: Carlos Delgado
 * @Version: 1
 * @Date: 03/JUL/2023
 */
package project;

public class VerifyTree {
  
  /**
   * Verifica que el árbol de Huffman sea válido.
   * @param tree árbol de Huffman
   * @return true si el árbol es válido, false de lo contrario
   */
  public boolean verify(HuffmanBinaryTree tree){
    int key = tree.getNumberKey();
    if (key != -1){
      HuffmanBinaryTree left = tree.getLeft();
      HuffmanBinaryTree right = tree.getRight();

      if (left != null && right != null){
        boolean condition = key >= left.getNumberKey() && key >= right.getNumberKey();
        return condition && verify(left) && verify(right);
      }
      else{
        if (left == null){
          boolean condition = key >= right.getNumberKey();
          return condition && verify(right);
        }
        else {
          if (right == null){
            boolean condition = key >= left.getNumberKey();
            return condition && verify(left);
          }
          else{
            return true;
          }
        }
      }
    }
    else{
      return true;
    }
  }
}
