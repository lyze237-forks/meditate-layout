package facebook.yoga;

import static facebook.GlobalMembers.YGNodeClone;
import java.util.ArrayList;

public class YGConfig implements Cloneable //Type originates from: YGConfig.h
{
    @Override
    public YGConfig clone() {
        try {
            return (YGConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean useWebDefaults = false;
    public boolean useLegacyStretchBehaviour = false;
    public boolean shouldDiffLayoutWithoutLegacyStretchBehaviour = false;
//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//struct;
//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//Struct;
    public boolean printTree = false;
    public float pointScaleFactor = 1.0f;
//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//struct;
//C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//Struct;
    public ArrayList<Boolean> experimentalFeatures = new ArrayList<Boolean>();
    public Object context = null;
    //C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//struct;
    private cloneNodeCallback_Struct cloneNodeCallback_struct = new cloneNodeCallback_Struct();
    //C++ TO JAVA CONVERTER NOTE: Access declarations are not available in Java:
//struct;
    private logger_Struct logger_struct = new logger_Struct();
    private boolean cloneNodeUsesContext_;
    private boolean loggerUsesContext_;

    public YGConfig(YGLogger logger) //Method definition originates from: YGConfig.cpp
    {
        this.cloneNodeCallback_struct = null;
        logger_struct.noContext = logger;
        loggerUsesContext_ = false;
    }

    public final void log(YGConfig config, YGNode node, YGLogLevel logLevel, Object logContext, String format, Object... args) //Method definition originates from: YGConfig.cpp
    {
        if (loggerUsesContext_) {
            logger_struct.withContext.invoke(config, node, logLevel, logContext, format, args);
        } else {
            logger_struct.noContext.invoke(config, node, logLevel, format, args);
        }
    }

    public final void setLogger(YGLogger logger) {
        logger_struct.noContext = logger;
        loggerUsesContext_ = false;
    }

    public final void setLogger(LogWithContextFn logger) {
        logger_struct.withContext = logger;
        loggerUsesContext_ = true;
    }

    public final void setLogger() {
        logger_struct.noContext = null;
        loggerUsesContext_ = false;
    }

    public final YGNode cloneNode(YGNode node, YGNode owner, int childIndex, Object cloneContext) //Method definition originates from: YGConfig.cpp
    {
        YGNode clone = null;
        if (cloneNodeCallback_struct.noContext != null) {
            clone = cloneNodeUsesContext_ ? cloneNodeCallback_struct.withContext.invoke(node, owner, childIndex,
                    cloneContext) : cloneNodeCallback_struct.noContext.invoke(node, owner, childIndex);
        }
        if (clone == null) {
            clone = YGNodeClone(node);
        }
        return clone;
    }

    public final void setCloneNodeCallback(YGCloneNodeFunc cloneNode) {
        cloneNodeCallback_struct.noContext = cloneNode;
        cloneNodeUsesContext_ = false;
    }

    public final void setCloneNodeCallback(CloneWithContextFn cloneNode) {
        cloneNodeCallback_struct.withContext = cloneNode;
        cloneNodeUsesContext_ = true;
    }

    public final void setCloneNodeCallback() {
        cloneNodeCallback_struct.noContext = null;
        cloneNodeUsesContext_ = false;
    }

    @FunctionalInterface
    public interface LogWithContextFn {
        int invoke(YGConfig config, YGNode node, YGLogLevel level, Object context, String format, Object... args);
    }

    @FunctionalInterface
    public interface CloneWithContextFn {
        YGNode invoke(YGNode node, YGNode owner, int childIndex, Object cloneContext);
    }

    //C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
    private static class cloneNodeCallback_Struct {

        CloneWithContextFn withContext;
        YGCloneNodeFunc noContext;

    }

    //C++ TO JAVA CONVERTER TODO TASK: The following method format was not recognized, possibly due to an unrecognized macro:
    private static class logger_Struct {

        LogWithContextFn withContext;
        YGLogger noContext;

    }
}
