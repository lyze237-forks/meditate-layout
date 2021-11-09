package facebook.yoga.internal;

public class GlobalMembers
{
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	void enable(Experiment UnnamedParameter);
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	void disable(Experiment UnnamedParameter);
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
//	boolean toggle(Experiment UnnamedParameter);


	public static void enable(Experiment experiment)
	{
	  detail.GlobalMembers.enabledExperiments.set((Integer)experiment);
	}

	public static void disable(Experiment experiment)
	{
	  detail.GlobalMembers.enabledExperiments.reset((Integer)experiment);
	}

	public static boolean toggle(Experiment experiment)
	{
	  var bit = (Integer)experiment;
	  var previousState = detail.GlobalMembers.enabledExperiments.test(bit);
	  detail.GlobalMembers.enabledExperiments.flip(bit);
	  return previousState != null;
	}

	public static boolean isEnabled(Experiment experiment)
	{
	  return detail.enabledExperiments.test((Integer)experiment);
	}

	public static void disableAllExperiments()
	{
	  detail.enabledExperiments = 0;
	}
}