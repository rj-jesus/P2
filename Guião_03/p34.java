import static java.lang.System.*;
import pt.ua.prog.*;

public class p34
{
   public static void main(String[] args)
   {
      Agenda agenda = new Agenda();
      agenda.newNote(new Nota(new Data(14,6,2012), new Data(27,6,2012), "Prog2: APF"));
      agenda.newNote(new Nota(new Data(2,7,2012), new Data(13,7,2012), "Prog2: Recurso"));
      agenda.newNote(new Nota(new Data(6,6,2012), new Data(6,6,2012), "Prog2: ACITP2"));
      agenda.newNote(new Nota(new Data(9,5,2012), new Data(9,5,2012), "Prog2: AIP"));
      agenda.newNote(new Nota(new Data(22,3,2012), new Data(27,3,2012), "Prog2: ACITP1"));
      agenda.printNotes();
      out.println();
      Data d1 = new Data(27,3,2012);
      Data d2 = new Data(15,6,2012);
      Nota[] todo = agenda.appointments(d1, d2);
      out.print("Compromissos de ");
      d1.printDate();
      out.print(" a ");
      d2.printDate();
      out.println(":");
      for(int i = 0; i < todo.length; i++)
         todo[i].printNote();
   }
}

