package com.xti.jenkins.plugin.awslambda;

/*
 * #%L
 * AWS Lambda Upload Plugin
 * %%
 * Copyright (C) 2015 XT-i
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import hudson.EnvVars;
import hudson.Util;
import org.kohsuke.stapler.DataBoundConstructor;

public class LambdaVariables {
    private String awsAccessKeyId;
    private String awsSecretKey;
    private String awsRegion;
    private String artifactLocation;
    private String description;
    private String functionName;
    private String handler;
    private Integer memorySize;
    private String mode;
    private String role;
    private String runtime;
    private Integer timeout;
    private boolean successOnly;

    @DataBoundConstructor
    public LambdaVariables(String awsAccessKeyId, String awsSecretKey, String awsRegion, String artifactLocation, String description, String functionName, String handler, Integer memorySize, String mode, String role, String runtime, Integer timeout, boolean successOnly) {
        this.awsAccessKeyId = awsAccessKeyId;
        this.awsSecretKey = awsSecretKey;
        this.awsRegion = awsRegion;
        this.artifactLocation = artifactLocation;
        this.description = description;
        this.functionName = functionName;
        this.handler = handler;
        this.memorySize = memorySize;
        this.mode = mode;
        this.role = role;
        this.runtime = runtime;
        this.timeout = timeout;
        this.successOnly = successOnly;
    }

    public String getAwsAccessKeyId() {
        return awsAccessKeyId;
    }

    public String getAwsSecretKey() {
        return awsSecretKey;
    }

    public String getAwsRegion() {
        return awsRegion;
    }

    public String getArtifactLocation() {
        return artifactLocation;
    }

    public String getDescription() {
        return description;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getHandler() {
        return handler;
    }

    public Integer getMemorySize() {
        return memorySize;
    }

    public String getMode() {
        return mode;
    }

    public String getRole() {
        return role;
    }

    public String getRuntime() {
        return runtime;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public boolean getSuccessOnly(){
        return successOnly;
    }

    public void setAwsAccessKeyId(String awsAccessKeyId) {
        this.awsAccessKeyId = awsAccessKeyId;
    }

    public void setAwsSecretKey(String awsSecretKey) {
        this.awsSecretKey = awsSecretKey;
    }

    public void setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }

    public void setArtifactLocation(String artifactLocation) {
        this.artifactLocation = artifactLocation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public void setMemorySize(Integer memorySize) {
        this.memorySize = memorySize;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public void setSuccessOnly(boolean successOnly) {
        this.successOnly = successOnly;
    }

        public void expandVariables(EnvVars env) {
        awsAccessKeyId = expand(awsAccessKeyId, env);
        awsSecretKey = expand(awsSecretKey, env);
        awsRegion = expand(awsRegion, env);
        artifactLocation = expand(artifactLocation, env);
        description = expand(description, env);
        functionName = expand(functionName, env);
        handler = expand(handler, env);
        mode = expand(mode, env);
        role = expand(role, env);
        runtime = expand(runtime, env);
    }

    private String expand(String value, EnvVars env) {
        return Util.replaceMacro(value.trim(), env);
    }
}