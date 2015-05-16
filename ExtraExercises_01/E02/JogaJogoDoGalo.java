import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;
    
public class JogaJogoDoGalo {
  public static void main(String[] args) {
    Scanner sin = new Scanner(in);
    char jogador1 = 'X';
    char jogador2 = 'O';
    JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
    int lin = -1, col = -1;
    int nJogos = 0, nJog1 = 0, nJog2 = 0, nEmps = 0;
    jogo.mostraTabuleiro();
    while ((nEmps + nJog1 + nJog2) < 10 && nJog1 < 3 && nJog2 < 3) {
      out.print("(lin col): ");
	  lin = sin.nextInt();
	  col = sin.nextInt();
	  while(!jogo.jogadaValida(lin, col)){
	    out.print("ERRO: Jogada invalida!\n");
	    out.print("(lin col): ");
	    lin = sin.nextInt();
	    col = sin.nextInt();
	  }
      jogo.jogada(lin, col);
      jogo.mostraTabuleiro();
      if(jogo.terminado()){
		  
		  
	    if(jogo.ultimoJogadorGanhou()){
          if(jogo.ultimoJogador() == jogador1){
		    nJog1++;
		    out.println("Jogador "+jogador1+" ganhou!");
          }
		  else{
            nJog2++;
            out.println("Jogador "+jogador2+" ganhou!");
          }
        }
	    else{
          nEmps++;
          out.println("Jogo empatado.");
	    }
	    out.println("\nJogador | Vitórias | Derrotas | Empates");
	    out.println("   " + jogador1 + "    |     " + nJog1 + "    |     " + nJog2 + "    |    " + nEmps);
	    out.println("   " + jogador2 + "    |     " + nJog2 + "    |     " + nJog1 + "    |    " + nEmps);
	    if((nEmps + nJog1 + nJog2) < 10 && nJog1 < 3 && nJog2 < 3){
		  jogo = new JogoDoGalo(jogador1, jogador2);
		  jogo.mostraTabuleiro();
	    }
	    else{
		  out.print("\n");
		  break;
	    }
	  }
	  
    }
  }
}
