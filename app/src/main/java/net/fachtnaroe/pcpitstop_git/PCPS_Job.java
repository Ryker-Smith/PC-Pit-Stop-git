package net.fachtnaroe.pcpitstop_git;

public class PCPS_Job
{
    private int JobNum;
    private int CustNum;
    private String Details;
    private String Location;
    private String Status;

    public PCPS_Job(int JobNumber, int CustomerNumber, String JobDetails, String JobLocation)
    {

    }

    public void setDetails(String JobDetails)
    {
        Details = JobDetails;
    }

    public String getDetails()
    {
        return Details;
    }

    public void setLocation(String JobLocation)
    {
        Location = JobLocation;
    }

    public String getLocation()
    {
        return Location;
    }

    public void setStatus(String JobStatus)
    {
        Status = JobStatus;
    }

    public String getStatus()
    {
        return Status;
    }
}
