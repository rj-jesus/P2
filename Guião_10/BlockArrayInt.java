public class BlockArrayInt
{
   public BlockArrayInt(int blockSize,int numBlocks)
   {
      assert blockSize > 0;
      assert numBlocks > 0;

      a = new int[blockSize*numBlocks];
      blocks++;
   }

   public int get(int index)
   {
      assert validIndex(index);

      return a[index];
   }

   public void put(int elem,int index)
   {
      assert validIndex(index);

      a[index] = elem;
   }

   public void incrementNumberOfBlocks()
   {
      int[] brr = new int[a.length+a.length / blocks];
      for(int i = 0; i < a.length; i++) brr[i] = a[i];
      a = brr;
      blocks++;
   }

   public int size()
   {
      return a.length;
   }

   public int numberOfBlocks()
   {
      return blocks;
   }

   public int blockSize()
   {
      return a.length / blocks;
   }

   public boolean validIndex(int index)
   {
      return index >= 0 && index < size();
   }

   private int[] a;
   private int blocks = 0;
}

