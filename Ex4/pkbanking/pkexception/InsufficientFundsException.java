package pkbanking.pkexception;

public class InsufficientFundsException extends Exception
{
  String desc;

  public InsufficientFundsException()
  {
    desc="Insufficient Funds";
  }

  public InsufficientFundsException(String d)
  {
    desc=d;
  }

  public String toString()
  {
    return desc;
  }
}
