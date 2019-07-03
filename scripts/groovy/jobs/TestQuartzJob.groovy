package jobs

import com.es.job.demo.quartz.job.JobBean
import org.elasticsearch.client.Client
import org.springframework.beans.factory.annotation.Autowired

class TestQuartzJob extends JobBean {
    @Autowired
    private Client client

    @Override
    Object loadData() {
        return [",32", "234"]
    }

    @Override
    void writeData(Object data) {
        println data
    }

    @Override
    String getTitle() {
        return "test"
    }

    @Override
    String getTrigger() {
        return "* * * * * ?"
    }

    @Override
    int getOrder() {
        return 0
    }
}