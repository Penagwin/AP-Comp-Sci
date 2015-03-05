public class GrayImage
{
  public static final int BLACK = 0;
  public static final int WHITE = 255;

  /** The 2-dimensional representation of this image. Guaranteed not to be null.
   * All values in the array are within the range [BLACK, WHITE], inclusive.
   */
  private int[][] pixelValues;

  public GrayImage(int[][] pixels)
  {
    pixelValues = new int[pixels.length][];
    for (int r = 0; r < pixels.length; r++)
      pixelValues[r] = java.util.Arrays.copyOf(pixels[r], pixels[r].length);
  }

  // Part (a)

  /** @return the total number of white pixels in this image.
   *    Postcondition: this image has not been changed.
   */
  public int countWhitePixels()
  {
    int total = 0;
    for(int x = 0; x < pixelValues.length; x++)
      for(int y = 0; y < pixelValues[0].length; y++)
        if(pixelValues[x][y] == 255) total++;
   return total;
  }

  // Part (b)

  /** Processes this image in row-major order and decreases the value of each pixel at
   * position (row, col) by the value of the pixel at position (row + 2, col + 2) if it exists.
   * Resulting values that would be less than BLACK are replaced by BLACK.
   * Pixels for which there is no pixel at position (row + 2, col + 2) are unchanged.
   */
  public void processImage(){
   
    for(int x = 0; x < pixelValues.length - 2; x++)
      for(int y = 0; y < pixelValues[0].length - 2; y++){

        pixelValues[x][y] -= pixelValues[x+2][y+2]; 
        if(pixelValues[x][y] < 0) pixelValues[x][y] = 0;
      }

  }


  public String toString()
  {
    String s = "";
    for (int[] row : pixelValues)
    {
      for (int x : row)
        s += String.format(" %3d", x);
      s += "\n";
    }
    return s;
  }
}