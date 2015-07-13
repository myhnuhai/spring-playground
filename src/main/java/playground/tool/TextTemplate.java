package playground.tool;

import com.samskivert.mustache.Mustache;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

@Component
public class TextTemplate {

    private String prefix = "";
    private String suffix = "";
    private String encoding = "UTF-8";

    @PostConstruct
    private void init() {
        Assert.hasText(prefix);
        Assert.hasText(suffix);
        Assert.hasText(encoding);

        if (prefix.startsWith("/")) {
            prefix = prefix.substring(1);
        }

        if (!prefix.endsWith("/")) {
            prefix = prefix + "/";
        }
    }

    public String render(String templateName, Object datas) {
        InputStream inputStream = ClassUtils.getDefaultClassLoader().getResourceAsStream(prefix + templateName + suffix);
        Reader reader;
        try {
            reader = new InputStreamReader(inputStream, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }

        String result = Mustache.compiler().compile(reader).execute(datas);
        IOUtils.closeQuietly(reader);
        IOUtils.closeQuietly(inputStream);
        return result;
    }

    @Value("${app.txttmp.prefix}")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Value("${app.txttmp.suffix}")
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Value("${app.txttmp.encoding}")
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

}
