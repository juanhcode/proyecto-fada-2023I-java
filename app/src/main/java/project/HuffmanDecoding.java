/**
 * Clase de decodificacion de Huffman
 * Esta clase se encarga de decodificar un texto en base a un arbol de huffman
 * @Author: <Estudiantes>
 * @Version: <1>
 */
package project;

public class HuffmanDecoding {
  
  /**
   * Decodifica un texto en base a un arbol de huffman.
   * @param text texto a decodificar
   * @param tree arbol de huffman
   * @return texto decodificado
   */
  public String decode(String text, HuffmanBinaryTree tree) {
    StringBuilder decoded = new StringBuilder();
    HuffmanBinaryTree currentNode = tree.getPadre();

    for (char bit : text.toCharArray()) {
      if (bit == '0') {
        currentNode = currentNode.getLeft();
      } else if (bit == '1') {
        currentNode = currentNode.getRight();
      }

      if (currentNode.getLeft() == null && currentNode.getRight() == null) {
        Object letra = currentNode.getLetra();
        if (letra instanceof Character) {
          char character = (char) letra;
          if (character == '\n') {
            decoded.append(System.lineSeparator());  // Reemplaza '\n' con salto de línea en el sistema operativo actual
          } else {
            decoded.append(character);
          }
          currentNode = tree.getPadre();
        }
        }
      }

    return decoded.toString();
  }
}
