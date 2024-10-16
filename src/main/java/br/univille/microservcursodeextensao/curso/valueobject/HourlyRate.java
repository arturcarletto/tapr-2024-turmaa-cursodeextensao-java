package br.univille.microservcursodeextensao.curso.valueobject;

import java.util.Objects;

public class HourlyRate {

    private double hourlyRate;

    public HourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HourlyRate that = (HourlyRate) o;
        return Double.compare(hourlyRate, that.hourlyRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hourlyRate);
    }

    @Override
    public String toString() {
        return "HourlyRate{" +
                "hourlyRate=" + hourlyRate +
                '}';
    }
}
