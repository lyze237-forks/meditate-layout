package io.github.orioncraftmc.meditate.internal;

import static io.github.orioncraftmc.meditate.internal.GlobalMembers.YGNodeClone;
import io.github.orioncraftmc.meditate.internal.enums.YGExperiment;
import io.github.orioncraftmc.meditate.internal.enums.YGLogLevel;
import io.github.orioncraftmc.meditate.internal.interfaces.YGCloneNodeFunc;
import io.github.orioncraftmc.meditate.internal.interfaces.YGLogger;
import java.util.ArrayList;

public class YGConfig //Type originates from: YGConfig.h
{
    private logger_Struct logger_struct = new logger_Struct();
    public boolean useWebDefaults = false;
    public boolean useLegacyStretchBehaviour = false;
    public boolean shouldDiffLayoutWithoutLegacyStretchBehaviour = false;
    public boolean printTree = false;
    public float pointScaleFactor = 1.0f;
    public ArrayList<Boolean> experimentalFeatures = new ArrayList<>();
    public Object context = null;
    private cloneNodeCallback_Struct cloneNodeCallback_struct = new cloneNodeCallback_Struct();
    private boolean cloneNodeUsesContext_;
    private boolean loggerUsesContext_;

    public YGConfig(YGLogger logger) //Method definition originates from: YGConfig.cpp
    {
        this.cloneNodeCallback_struct = null;
        logger_struct.noContext = logger;
        loggerUsesContext_ = false;
        for (int i = 0; i < YGExperiment.values().length; i++) {
            experimentalFeatures.add(false);
        }
    }

    public YGConfig shallowClone() {
        YGConfig clone = new YGConfig(logger_struct.noContext);

        clone.logger_struct = this.logger_struct;
        clone.useWebDefaults = this.useWebDefaults;
        clone.useLegacyStretchBehaviour = this.useLegacyStretchBehaviour;
        clone.shouldDiffLayoutWithoutLegacyStretchBehaviour = this.shouldDiffLayoutWithoutLegacyStretchBehaviour;
        clone.printTree = this.printTree;
        clone.pointScaleFactor = this.pointScaleFactor;
        clone.experimentalFeatures = this.experimentalFeatures;
        clone.context = this.context;
        clone.cloneNodeCallback_struct = this.cloneNodeCallback_struct;
        clone.cloneNodeUsesContext_ = this.cloneNodeUsesContext_;
        clone.loggerUsesContext_ = this.loggerUsesContext_;

        return clone;
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

    public final  YGNode cloneNode(YGNode node, YGNode owner, int childIndex, Object cloneContext) //Method definition originates from: YGConfig.cpp
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

    private static class cloneNodeCallback_Struct {

        CloneWithContextFn withContext;
         YGCloneNodeFunc noContext;

    }

    private static class logger_Struct {

        LogWithContextFn withContext;
         YGLogger noContext;

    }
}
