package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

/**
 * @author pangkun
 * @date 2019/5/29 上午11:11
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @CrossOrigin
    @GetMapping("")
    public String get() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("高血压（hypertension）是指以体循环动脉血压（收缩压和/或舒张压）增高为主要特征（收缩压≥140毫米汞柱，舒张压≥90毫米汞柱），可伴有心、脑、肾等器官的功能或器质性损害的临床综合征。高血压是最常见的慢性病，也是心脑血管病最主要的危险因素。正常人的血压随内外环境变化在一定范围内波动。在整体人群，血压水平随年龄逐渐升高，以收缩压更为明显，但50岁后舒张压呈现下降趋势，脉压也随之加大。近年来，人们对心血管病多重危险因素的作用以及心、脑、肾靶器官保护的认识不断深入，高血压的诊断标准也在不断调整，目前认为同一血压水平的患者发生心血管病的危险不同，因此有了血压分层的概念，即发生心血管病危险度不同的患者，适宜血压水平应有不同。血压值和危险因素评估是诊断和制定高血压治疗方案的主要依据，不同患者高血压管理的目标不同，医生面对患者时在参考标准的基础上，根据其具体情况判断该患者最合适的血压范围，采用针对性的治疗措施。在改善生活方式的基础上，推荐使用24小时长效降压药物控制血压。除评估诊室血压外，患者还应注意家庭清晨血压的监测和管理，以控制血压，降低心脑血管事件的发生率。");
        jsonArray.add("当血糖值高于正常范围即为高血糖。高血糖也是通常大家所说“三高”中的一高。另外“两高”分别是高血压和高脂血症。空腹血糖正常值在6.1mmol/L以下，餐后两小时血糖的正常值在7.8mmol/L以下，如果高于这一范围，称为高血糖。\n" +
                "高血糖和糖尿病是有着密切联系但又非常不同的两个概念，应当注意两点：\n" +
                "1.高血糖不是一种疾病的诊断，只是一种血糖监测结果的判定，血糖监测是一时性的结果，可受到很多因素的影响，如去除这些因素血糖有可能恢复正常。而疾病（如糖尿病）则是一个相对稳定的状态，糖尿病的诊断需要除外一些应激性因素的干扰，在单纯血糖增高的基础上需要重复测定或患者有明显的症状才能诊断。\n" +
                "2.高血糖包括糖尿病前期和糖尿病。糖尿病前期是指血糖已经升高，但还没有达到糖尿病诊断标准，血糖介于正常与糖尿病之间的一种情况。正常人的空腹血糖应低于6.1mmol/L，而诊断糖尿病的空腹血糖应等于或者高于7.0mmol/L，这两个数值之间有个差距。同样，正常人的餐后两小时血糖应低于7.8mmol/L，而诊断糖尿病的餐后两小时血糖应等于或者高于11.1mmol/L，两者之间也有个差距。如果一个人的血糖正好在这两个差距内，也就是说空腹血糖在6.1mmol/L～7.0mmol/L之间，和/或餐后两小时血糖在7.8mmol/L～11.1mmol/L之间，这时的血糖既不正常，又没有达到糖尿病的程度，就称为糖尿病前期。 ");
        jsonArray.add("BMI值原来的设计是一个用于公众健康研究的统计工具。当我们需要知道肥胖是否对某一疾病的致病原因时，我们可以把病人的身高及体重换算成BMI值，再找出其数值及病发率是否有线性关联。不过，随着科技进步，现时BMI值只是一个参考值。要真正量度病人是否肥胖，还需要利用微电力量度病人的阻抗，以推断病者的脂肪厚度。因此，BMI的角色也慢慢改变，从医学上的用途，变为一般大众的纤体指标。\n" +
                "体质指数（BMI）=体重（kg）÷身高（m）的平方");
        jsonObject.put("data", jsonArray);
        return jsonObject.toString();
    }
}
