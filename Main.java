import java.util.*;

public class Main {
  public static boolean comp;

  public static void main(String[] args) {
    Scanner yo = new Scanner(System.in);
    Comp c = new Comp();
    noComp n = new noComp();
    System.out.println("WELCOME TO ERRY'S UNO GAME!\n");
    System.out.println("Would you wish to play with the computer?\n1. Yes\n2. No");
    int r = yo.nextInt();
    if (r == 1){
      comp=true;
      c.main(new String[] { "k" });
    }
    else {
      n.main(new String[] { "ok" });
      comp = false;
    }
  }
}
