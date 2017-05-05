package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.user.Post;
import ig.zeus.domain.repository.command.IPostRepository;
import ig.zeus.domain.service.IPostService;
import ig.zeus.domain.service.command.PostCommand;

public class PostService implements IPostService {
	private DozerBeanMapper dozer = new DozerBeanMapper();
	private IPostRepository iPostRepository;
	private Post post;
	private PostCommand postCommand;

	public IPostRepository getiPostRepository() {
		return iPostRepository;
	}

	public void setiPostRepository(IPostRepository iPostRepository) {
		this.iPostRepository = iPostRepository;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public PostCommand getPostView() {
		return postCommand;
	}

	public void setPostView(PostCommand postCommand) {
		this.postCommand = postCommand;
	}

	@Override
	public int remove(Integer id) {
		return iPostRepository.remove(id);
	}

	@Override
	public int add(PostCommand entity) {
		post = dozer.map(entity, Post.class);
		iPostRepository.add(post);
		return post.getID();
	}

	@Override
	public int update(PostCommand entity) {
		post = dozer.map(entity, Post.class);
		return iPostRepository.update(post);
	}
}
