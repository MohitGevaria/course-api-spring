package springtutorial.metadata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
public class MetadataController {

    @Autowired
    private MetadataService metadataService;

    @RequestMapping("/blogs/{blogId}/metadata")
    public List<Metadata> getMetadata(@PathVariable String blogId){
        return metadataService.getMetadata(blogId);
    }

//    @RequestMapping("/blogs/{blogId}/metadata/{id}")
//    public Metadata getMetadataById(@PathVariable String id){
//        return metadataService.getMetadata(id);
//    }

    @RequestMapping(method = RequestMethod.POST, value="/blogs/{blogsId}/metadata")
    public void addMetadata(@RequestBody Metadata metadata, @PathVariable String blogId){
        metadata.setBlogId(blogId);
        metadata.setDate_uploaded(new Date());
        metadataService.addMetadata(metadata);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/blogs/{blogsId}/metadata/{id}")
    public void updateMetadata(@RequestBody Metadata metadata, @PathVariable String id){
        metadataService.updateMetadata(metadata, id);
    }


}
