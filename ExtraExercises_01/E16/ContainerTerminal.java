//NMEC: 
//NOME: 
import static java.lang.System.*;

public class ContainerTerminal {
  ContainerStack[] sa;    // the stacks of containers
  int num;  // number of parallel stacks of containers
  int max;  // maximum height of each stack of containers
  int numcontainers;  // number of containers on the terminal
  
  public ContainerTerminal(int num, int max) {
    sa = new ContainerStack[num];
    for (int k = 0; k < num; k++) {
      sa[k] = new ContainerStack(max);
    }
    this.num = num;
    this.max = max;
    numcontainers = 0;
  }
    public void store(Container container){
        assert !isFull() : "The terminal is full.";
        int idx = findOtherStack(-1);
        sa[idx].push(container);
        numcontainers++;
        assert container == sa[idx].top();
    }
    public Container retrieve(String type){
        int idx = findStackContaining(type);
        Container result = null;
        if(idx != -1){
            while(sa[idx].search(type) != 0){
                sa[findOtherStack(idx)].push(sa[idx].top());
                sa[idx].pop();
            }
            result = sa[idx].top();
            logContainerInfo(result);
            sa[idx].pop();
            numcontainers--;
        }
        return result;
    }
    public double averageOpsPerContainer(){
        assert log != null : "Can't get the average of an empty set of data.";
        return averageOpsPerContainer(log, 0, 0);
    }
    private double averageOpsPerContainer(HistoryNode node, int sum, int elements){
        if(node != null) return averageOpsPerContainer(node.next, sum+node.numops, elements+1);
        else return sum / elements;
    }
  /**
   * Is the terminal full?
   * A full terminal must still have enough free space to enable
   * retrieving any given container.
   */
  public boolean isFull() {
    return numcontainers >= num*max - max;
  }
  
  /**
   * Checks if a container of a certain type exists
   */
  public boolean containerTypeExists(String type) {
    return findStackContaining(type) >= 0;
  }

  
  /**
   * Find first stack with free space, other than the stackToAvoid.
   * @return the index of the found stack
   */
  private int findOtherStack(int stackToAvoid) {
    assert !isFull();
    int k = 0;
    while (k==stackToAvoid || sa[k].isFull()) {
      k++;
    }
    return k;
  }
  
  /**
   * Find a stack that includes a container with a given type of cargo
   * @return the index of the found stack, or -1 if no such cargo exists.
   */
  private int findStackContaining(String type) {
    int k = 0;
    while (k < num) {
      if (sa[k].search(type) >= 0) return k;
      k++;
    }
    return -1;
  }
  
  public void print() {
    out.printf("Terminal numcontainers=%d isFull=%s\n",
                      numcontainers, isFull());
    for (int k = 0; k < num; k++) {
      out.printf("%2d: %s\n", k, sa[k].toString());
    }
  }

  // Log: historical log of retrieved containers: it's a linked list
  HistoryNode log;

  private void logContainerInfo(Container c) {
    HistoryNode n = new HistoryNode();
    //n.type = c.type();
    n.numops = c.numops();
    n.next = log;
    log = n;
  }
  
}
