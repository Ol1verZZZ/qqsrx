package qqsrx.spring.boot.minidouban.domain;

public class JsonResult {
    private String status = null;   //返回的状态
    private Object result = null;   //返回的数据

    public JsonResult status(String status) {
        this.status = status;
        return this;
    }

    // Getter Setter
    public String getStatus() {
        return status;
    }

    public Object getResult() {
        return result;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
