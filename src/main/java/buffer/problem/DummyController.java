package buffer.problem;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.HttpStatus;
import io.micronaut.protobuf.codec.ProtobufferCodec;

@Controller("/dummy")
public class DummyController {

    private static int counter = 0;

    @Get("/okey")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Post("/issue")
    @Consumes(ProtobufferCodec.PROTOBUFFER_ENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public HttpResponse issueMethod (@Body byte[] body) {
        counter++;
        System.out.println(counter);
        return HttpResponse.ok(body);
    }
}