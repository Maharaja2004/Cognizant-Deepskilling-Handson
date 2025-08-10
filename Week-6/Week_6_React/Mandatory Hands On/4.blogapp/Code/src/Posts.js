import React from 'react';
import Post from './Post';


class Posts extends React.Component{
    constructor(props){
        super(props);
        this.state={posts:[]};
    }


loadPosts=()=>{
  fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => {
                const postObjects = data.slice(0, 10).map(post =>
                    new Post(post.id, post.title, post.body)
                );
                this.setState({ posts: postObjects });
            })
            .catch(error => {
                console.error("Error fetching posts:", error);
                throw error;
            });

}
componentDidMount(){
    this.loadPosts();
}
componentDidCatch(error, info) {
        alert("An error occurred while loading posts.");
        console.error("Error:", error);
        console.error("Info:", info);
    }

    render() {
        return (
            <div>
                <h1>Blog Posts</h1>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ border: "1px solid #ccc", margin: "10px", padding: "10px" }}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}
export default Posts;