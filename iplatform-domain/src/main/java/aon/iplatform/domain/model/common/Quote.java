package aon.iplatform.domain.model.common;


import aon.iplatform.domain.model.insurer.Insurer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 */
@ApiModel(value="Quote", description="Insurer Quote")
public class Quote {
    private Insurer insurer;
    private Premium premium;

    @ApiModelProperty(value = "Insurer")
    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    @ApiModelProperty(value = "Premium")
    public Premium getPremium() {
        return premium;
    }

    public void setPremium(Premium premium) {
        this.premium = premium;
    }
}
