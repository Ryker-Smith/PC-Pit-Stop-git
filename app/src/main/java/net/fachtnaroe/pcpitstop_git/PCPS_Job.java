package net.fachtnaroe.pcpitstop_git;

public class PCPS_Job
{
    private int jobNum;
    private int custNum;
    private String details;
    private String location;
    private String status;

    public PCPS_Job(int jobNumber, int customerNumber, String jobDetails, String jobLocation)
    {

    }

    public void setDetails(String jobDetails)
    {
        details = jobDetails;
    }

    public String getDetails()
    {
        return details;
    }

    public void setLocation(String jobLocation)
    {
        location = jobLocation;
    }

    public String getLocation()
    {
        return location;
    }

    public void setStatus(String jobStatus)
    {
        status = jobStatus;
    }

    public String getStatus()
    {
        return status;
    }
}
