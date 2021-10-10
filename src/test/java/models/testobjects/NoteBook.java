package models.testobjects;

import models.valueobjects.*;

public class NoteBook {
    private Company company;
    private Ram ram;
    private DiagonalRange diagonalRangeFrom;
    private DiagonalRange diagonalRangeApTo;
    private ProcessorType processorType;
    private GpuType gpuType;

    NoteBook(){

    }

    public NoteBook(Company company, Ram ram, DiagonalRange diagonalRangeFrom, DiagonalRange diagonalRangeApTo, ProcessorType processorType, GpuType gpuType) {
        this.company = company;
        this.ram = ram;
        this.diagonalRangeFrom = diagonalRangeFrom;
        this.diagonalRangeApTo = diagonalRangeApTo;
        this.processorType = processorType;
        this.gpuType = gpuType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public DiagonalRange getDiagonalRangeFrom() {
        return diagonalRangeFrom;
    }

    public void setDiagonalRangeFrom(DiagonalRange diagonalRangeFrom) {
        this.diagonalRangeFrom = diagonalRangeFrom;
    }

    public DiagonalRange getDiagonalRangeApTo() {
        return diagonalRangeApTo;
    }

    public void setDiagonalRangeApTo(DiagonalRange diagonalRangeApTo) {
        this.diagonalRangeApTo = diagonalRangeApTo;
    }

    public ProcessorType getProcessorType() {
        return processorType;
    }

    public void setProcessorType(ProcessorType processorType) {
        this.processorType = processorType;
    }

    public GpuType getGpuType() {
        return gpuType;
    }

    public void setGpuType(GpuType gpuType) {
        this.gpuType = gpuType;
    }
}
