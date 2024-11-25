create schema blogappdb;

use blogappdb;

create table blog_post(
    id bigint(20),
    title varchar(255),
    author varchar(255),
    content text,
    primary key (id)
);


INSERT INTO blog_post (id, title, author, content ) VALUES (1, 'Donec ultrices ut tellus ut consequat','Donatelo','Suspendisse sed tortor ut nunc dignissim ornare. Proin venenatis luctus aliquam. Nam et ante mauris. Vestibulum accumsan vulputate lacus ut sodales. Nullam pulvinar quis elit scelerisque ultricies. Proin vehicula urna ac sagittis laoreet. In consectetur tellus vel quam laoreet feugiat ac eu elit. Sed elementum quis arcu eget laoreet. Etiam non tellus tortor.');
INSERT INTO blog_post (id, title, author, content ) VALUES (2, 'Cras gravida lobortis sagittis','Michaelangelo','Aliquam fringilla condimentum eros, vitae tincidunt neque laoreet et. Donec massa tellus, vulputate venenatis interdum at, ornare ac metus. Donec non rhoncus odio. Sed at erat nec diam molestie commodo at semper eros. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin tortor elit, efficitur volutpat massa eu, semper facilisis risus. Cras tristique eget eros finibus porttitor. Vestibulum venenatis id justo non ullamcorper. Praesent eu mi venenatis, molestie nulla et, malesuada mauris. Sed vestibulum consequat lectus a lobortis');