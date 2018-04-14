class Book
	{
		String Bkname;
		int BkId;
		String BKAuthor;
		Book()
		{
			Bkname=" ";
			BkId=0;
			BKAuthor=" ";
		}
		Book(String a, String b , int id)
		{
			Bkname=a;
			BkId=id;
			BKAuthor=b;
		}
		void Bkupdate(String a, String b , int id)
		{
			Bkname=a;
			BkId=id;
			BKAuthor=b;
		}
		void Bkdisplay()
		{
			System.out.println("Book Name : "+Bkname);
			System.out.println("Author Name : "+BKAuthor);
			System.out.println("Book Id : "+BkId);
		}
	}
public class BookDemo
	{
		public static void main(String a[])
		{
			Book b1=new Book();
			Book b2=new Book("The Da Vinci Code","Dan Brown",4);
			Book b3=new Book("Inferno","Dan Brown",5);
			Book b4=new Book();
			b1.Bkdisplay();
			b2.Bkdisplay();
			b3.Bkdisplay();
			b4.Bkdisplay();
			b4.Bkupdate("HP","J.K Rowling",7);
			b4.Bkdisplay();
		}
	}
