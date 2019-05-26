package restApi.model;

public class Blad
{

	private Integer kod;
	private String tresc;
	private String stackTrace;

	public Integer getKod()
	{
		return kod;
	}

	public void setKod(Integer kod)
	{
		this.kod = kod;
	}

	public String getTresc()
	{
		return tresc;
	}

	public void setTresc(String tresc)
	{
		this.tresc = tresc;
	}

	public String getStackTrace()
	{
		return stackTrace;
	}

	public void setStackTrace(String stackTrace)
	{
		this.stackTrace = stackTrace;
	}

}
