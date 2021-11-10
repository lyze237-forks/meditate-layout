package facebook.yoga;

import java.util.*;

public class YGConfig //Type originates from: YGConfig.h
{
  @FunctionalInterface
  public interface LogWithContextFn
  {
	  int invoke(YGConfig config, YGNode node, YGLogLevel level, Object context, String format, va_list args);
  }

  @FunctionalInterface
  public interface CloneWithContextFn
  {
	  YGNodeRef invoke(YGNode node, YGNode owner, int childIndex, Object cloneContext);
  }


//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
Struct
{

	CloneWithContextFn withContext;
	YGCloneNodeFunc noContext;

}
//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//struct;
//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//Struct;

//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//struct;
private Struct struct = new Struct();
//C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
Struct
{

	LogWithContextFn withContext;
	YGLogger noContext;

}
//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//struct;
//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//Struct;

//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//struct;
private Struct struct = new Struct();
  private boolean cloneNodeUsesContext_;
  private boolean loggerUsesContext_;

  public boolean useWebDefaults = false;
  public boolean useLegacyStretchBehaviour = false;
  public boolean shouldDiffLayoutWithoutLegacyStretchBehaviour = false;
  public boolean printTree = false;
  public float pointScaleFactor = 1.0f;
  public ArrayList<Boolean> experimentalFeatures = new ArrayList<Boolean>();
  public Object context = null;

  public YGConfig(YGLogger logger) //Method definition originates from: YGConfig.cpp
  {
	  this.cloneNodeCallback_ = null;
	logger_.noContext = logger;
	loggerUsesContext_ = false;
  }

  public final void log(YGConfig config, YGNode node, YGLogLevel logLevel, Object logContext, String format, Object... args) //Method definition originates from: YGConfig.cpp
  {
	if (loggerUsesContext_)
	{
	  logger_.withContext(config, node, logLevel, logContext, format, args);
	}
	else
	{
	  logger_.noContext(config, node, logLevel, format, args);
	}
  }

  public final void setLogger(YGLogger logger)
  {
	struct.noContext = logger;
	loggerUsesContext_ = false;
  }
  public final void setLogger(LogWithContextFn logger)
  {
	struct.withContext = logger;
	loggerUsesContext_ = true;
  }
  public final void setLogger(std::nullptr_t UnnamedParameter)
  {
	  setLogger(YGLogger((null)));
  }

  public final YGNode cloneNode(YGNode node, YGNode owner, int childIndex, Object cloneContext) //Method definition originates from: YGConfig.cpp
  {
	YGNode clone = null;
	if (cloneNodeCallback_.noContext != null)
	{
	  clone = cloneNodeUsesContext_ ? cloneNodeCallback_.withContext(node, owner, childIndex, cloneContext) : cloneNodeCallback_.noContext(node, owner, childIndex);
	}
	if (clone == null)
	{
	  clone = YGNodeClone(node);
	}
	return clone;
  }

  public final void setCloneNodeCallback(YGCloneNodeFunc cloneNode)
  {
	struct.noContext = cloneNode;
	cloneNodeUsesContext_ = false;
  }
  public final void setCloneNodeCallback(CloneWithContextFn cloneNode)
  {
	struct.withContext = cloneNode;
	cloneNodeUsesContext_ = true;
  }
  public final void setCloneNodeCallback(std::nullptr_t UnnamedParameter)
  {
	setCloneNodeCallback(YGCloneNodeFunc((null)));
  }
}
