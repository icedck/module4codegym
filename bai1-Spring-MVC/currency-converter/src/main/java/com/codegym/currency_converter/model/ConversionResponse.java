package com.codegym.currency_converter.model;

public class ConversionResponse {
    private double usd;
    private double vnd;

    public ConversionResponse() {
    }

    public ConversionResponse(double usd, double vnd) {
        this.usd = usd;
        this.vnd = vnd;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getVnd() {
        return vnd;
    }

    public void setVnd(double vnd) {
        this.vnd = vnd;
    }
}
