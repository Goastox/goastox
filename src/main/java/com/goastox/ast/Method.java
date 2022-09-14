package com.goastox.ast;

import java.util.List;

public class Method {

    private String name;

    private List<String> returnType;

    private List<String> argumentList;

    private List<String> localVarList;

    private List<String> statementList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getReturnType() {
        return returnType;
    }

    public void setReturnType(List<String> returnType) {
        this.returnType = returnType;
    }

    public List<String> getArgumentList() {
        return argumentList;
    }

    public void setArgumentList(List<String> argumentList) {
        this.argumentList = argumentList;
    }

    public List<String> getLocalVarList() {
        return localVarList;
    }

    public void setLocalVarList(List<String> localVarList) {
        this.localVarList = localVarList;
    }

    public List<String> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<String> statementList) {
        this.statementList = statementList;
    }
}
