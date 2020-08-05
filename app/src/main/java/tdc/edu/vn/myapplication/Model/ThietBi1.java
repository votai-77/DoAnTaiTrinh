package tdc.edu.vn.myapplication.Model;

public class ThietBi1 {
    String maTB, tenTB, xuatXu, maLoai;

    public String getMaTB() {
        return maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public String toString() {
        return "ThietBi1{" +
                "maTB='" + maTB + '\'' +
                ", tenTB='" + tenTB + '\'' +
                ", xuatXu='" + xuatXu + '\'' +
                ", maLoai='" + maLoai + '\'' +
                '}';
    }
}
