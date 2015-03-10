import static java.lang.System.*;
import pt.ua.prog.Data;

public class p31
{
   public static void main(String[] args)
   {
      Data[] datas = new Data[args.length / 3]; // argumentos em grupos de três
      for(int i = 0; i < datas.length; i++)
      {
         int dia = Integer.parseInt(args[i*3]);
         int mes = Integer.parseInt(args[i*3+1]);
         int ano = Integer.parseInt(args[i*3+2]);
         datas[i] = new Data(dia, mes, ano);
      }

      boolean ordenado = true;
      for(int i = 1; ordenado && i < datas.length; i++)
         ordenado = datas[i].equalsTo(datas[i-1]) || datas[i].greaterThan(datas[i-1]);
      if (!ordenado)
         sort(datas);

      for(int i = 0; i < datas.length; i++)
         out.printf("%02d - %02d-%02d-%04d\n", (i+1), datas[i].day(), datas[i].month(), datas[i].year());
   }

   static void sort(Data[] datas)
   {
      for(int i = 0; i < datas.length; i++)
         for(int j = i+1; j < datas.length; j++)
           if (datas[j].lessThan(datas[i]))
           {
              Data tmp = datas[j];
              datas[j] = datas[i];
              datas[i] = tmp;
           }
   }
}

