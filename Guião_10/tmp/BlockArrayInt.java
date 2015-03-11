public class BlockArrayInt
{
   public void BlockArrayInt(int blockSize,int numBlocks)
   {
      assert blockSize > 0;
      assert numBlocks > 0;
      
      Node n = new Node();
      n.arr = new int[blockSize];
      n.block = numBlocks-1;
      n_blocks++;
      if(blocks == null) blocks = n;
      else{
		  n.prev = blocks;
		  blocks = n;
	  }
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
      BlockArrayInt(blocks.arr.length, n_blocks);
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

   private Node blocks = null;
   private int n_blocks = 0;
   private class Node{
	   int[] arr;
	   int block;
	   Node prev;
   }
}

