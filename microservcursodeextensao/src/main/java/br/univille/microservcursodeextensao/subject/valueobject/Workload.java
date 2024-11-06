package br.univille.microservcursodeextensao.subject.valueobject;

import lombok.Data;

@Data
public class Workload {

    private int workload;

    public Workload(int workload) {
        this.workload = workload;
    }

}
