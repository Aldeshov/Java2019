package pack;

public class problem4 
{
	public static void main(String[] args) {
		Chocolate c1 = new Chocolate("Aaa",10);
		Chocolate c2 = new Chocolate("Bbb",3);
		Chocolate c3 = new Chocolate("Ccc",17);
		Chocolate c4 = new Chocolate("Ddd",1);
		Chocolate c5 = new Chocolate("Eee",2);
		Chocolate [] c = new Chocolate[5];
		c[0] = c1;
		c[1] = c2;
		c[2] = c3;
		c[3] = c4;
		c[4] = c5;
		Sort.quicksort(c, 0, 4);
		for(int i = 0; i < c.length;i++) 
		{
			System.out.println(c[i]);
		}
		/*////////////////////////**//////////////////////////*/
		Time t1 = new Time(1,1,2);
		Time t2 = new Time(0,2,30);
		Time t3 = new Time(12,35,47);
		Time t4 = new Time(11,59,59);
		Time t5 = new Time(3,13,58);
		Time t6 = new Time(21,4,45);
		Time [] t = new Time[6];
		t[0] = t1;
		t[1] = t2;
		t[2] = t3;
		t[3] = t4;
		t[4] = t5;
		t[5] = t6;
		Sort.bubblesort(t);
		for(int i = 0; i <t.length;i++) 
		{
			System.out.println(t[i].toUniversal());
		}
	}
}