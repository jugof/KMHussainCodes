interface INumberCheck{
   boolean isCheck(int num);   
}
class EvenCheck implements INumberCheck{

        public boolean isCheck(int num){
		if (num%2 == 0)
			return true;
		return false;
	}
} 

class Program
{
   
   public static boolean myOddCheck(int num)
   {
	   if (num%2 != 0)
		   return true;
	   return false;
   }   
    
  class SumSpecific{
	private int lower;
	private int higher;

	public SumSpecific(int l, int h){
		lower = l;
		higher = h;
	}

        public int totalSum(INumberCheck check){
		int total = 0;

		for (int i = lower; i < higher; ++i){
			if (check.isCheck(i)){
				total = total + i;
			}
		}
		return total;
	}

 }


   public static void main(String[] args){
	   int l = Integer.parseInt(args[0]);
	   int h = Integer.parseInt(args[1]);

           SumSpecific sf = new Program().new SumSpecific(l, h);

	   System.out.printf("Total is :%d%n", sf.totalSum(new EvenCheck()));   
	   System.out.printf("Total is :%d%n", sf.totalSum(Program::myOddCheck));   

   }

}
