package java_8_20.post_tag;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Post {
    private int postId;
    private List<String> tags;

    public Post(int postId, List<String> tags) {
        this.postId = postId;
        this.tags = tags;
    }

    public int getPostId() {
        return postId;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", tags=" + tags +
                '}';
    }
}

class BlogPostTags{
    public static void main(String[] args) {
        Post post1 = new Post(1, Arrays.asList("java", "spring", "java"));
        Post post2 = new Post(2, Arrays.asList("python", "django", "python", "python"));
        Post post3 = new Post(3, Arrays.asList("java", "hibernate", "java"));

        List<Post> posts = Arrays.asList(post1, post2, post3);

        /* Map<Integer,String> mostCommonTag =  posts.stream().
                collect(Collectors.toMap(post->
                        post.getPostId(),
                        post -> post.getTags()
                                .stream().collect(Collectors.groupingBy(tag->tag,Collectors.counting()))
                                .entrySet().stream()
                                .max(Comparator.comparingLong(Map.Entry::getValue))
                                .map(Map.Entry::getKey)
                                .get()
                ));

       mostCommonTag.forEach((k,v)->{
           System.out.println("("+ k + ","+ v + ")");
       });*/

      posts.forEach((post)->{
       Map<String,Long> map=   post.getTags().stream().collect(Collectors.groupingBy(
                  tag->tag,
                  Collectors.counting()
          ));

          Map.Entry<String, Long> stringLongEntry = map.entrySet().stream().max(Comparator.comparingLong(
                  Map.Entry<String, Long>::getValue)).get();

          System.out.println(post.getPostId()+":"+stringLongEntry.getKey());
      });



    }
}
