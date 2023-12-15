BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO cake_flavors (flavor_name, is_available) VALUES ('Yellow', true);
INSERT INTO cake_flavors (flavor_name, is_available) VALUES ('Chocolate', true);
INSERT INTO cake_flavors (flavor_name, is_available) VALUES ('White', true);
INSERT INTO cake_flavors (flavor_name, is_available) VALUES ('Almond', true);
INSERT INTO cake_flavors (flavor_name, is_available) VALUES ('Red Velvet', true);
INSERT INTO cake_flavors (flavor_name, is_available) VALUES ('Marble', true);

INSERT INTO cake_frostings (frosting_name, is_available) VALUES ('Vanilla Buttercream', true);
INSERT INTO cake_frostings (frosting_name, is_available) VALUES ('Chocolate Buttercream', true);
INSERT INTO cake_frostings (frosting_name, is_available) VALUES ('Cream Cheese', true);

INSERT INTO cake_fillings (filling_name, is_available) VALUES ('Raspberry Jam', true);
INSERT INTO cake_fillings (filling_name, is_available) VALUES ('Fudge', true);
INSERT INTO cake_fillings (filling_name, is_available) VALUES ('Custard', true);
INSERT INTO cake_fillings (filling_name, is_available) VALUES ('Vanilla Buttercream', true);

INSERT INTO cake_sizes (size_name, is_available) VALUES ('Cupcake', true);
INSERT INTO cake_sizes (size_name, is_available) VALUES ('Bakers Dozen', true);
INSERT INTO cake_sizes (size_name, is_available) VALUES ('Small', true);
INSERT INTO cake_sizes (size_name, is_available) VALUES ('Large', true);

INSERT INTO cake_style (style_name, is_available) VALUES ('Round', true);
INSERT INTO cake_style (style_name, is_available) VALUES ('Square', true);
INSERT INTO cake_style (style_name, is_available) VALUES ('Cupcake', true);

INSERT INTO cake_price (cupcake_single, cupcake_bakers_dozen, small_cake, large_cake, small_cake_custom, large_cake_custom) VALUES (4.00, 48.00, 35.00, 50.00, 45.00, 60.00);


INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Dead Pet', 'Sorry your pet died. LOL! Round chocolate cake with custard filling and cream cheese frosting. Decorated with red buttercream napping pet, sorry that’ll be its last snooze. (Size: Small)', 35.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Ex Friend', 'You’re Dead to Us! Round chocolate cake with vanilla buttercream and chocolate ganache coating. Topped with a bloody knife, perfect for that back stabber. (Size: Small)', 35.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Breakup', 'I think we should see other people! Round red velvet cake with fudge filling and cream cheese frosting. So delicious, your soon-to-be ex just might forget all about you. (Size: Small)', 35.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Robbed', 'Sorry you got robbed! Elaborately decorated marble rectangle cake with colorful vanilla buttercream frosting. If they didn’t catch the guy, at least now they have cake. (Size: Small)', 40.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Divorced', 'Happy Divorce! Three tiered round cake with red velvet base, chocolate layer, vanilla top, and raspberry jam filling. Much more exciting than your failed marriage. (Size: Small)', 50.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Fired', 'You’re Fired! Classic yellow cake with vanilla buttercream frosting and filling. Boring and unoriginal, just like the terrible employee you’re about to kick to the curb. (Size: Small)', 35.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Failed', 'We Hope You Fail! Round almond cake with vanilla buttercream. Decorated with rainbow stripes and sprinkles to brighten the day of your favorite failure. (Size: Small)', 35.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Jail', 'Enjoy Prison! Round vanilla cake with chocolate buttercream and raspberry jam filling decorated with prison stripes, it’ll match their orange jumpsuit soon enough. Enjoy this last taste of freedom. (Size: Small)', 35.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Sued', 'You’ve Been Served! Round red velvet cake with fluffy cream cheese frosting and gold lettering. Tasty when served with court papers. (Size: Small)', 35.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Wreck', 'Sorry You’re a Terrible Driver! Rectangle white sheet cake with fudge filling and vanilla buttercream. It won’t pay for that ticket but it might ease the pain. (Size: Small)', 40.00, true);
INSERT INTO standard_cake (cake_name, description, price, is_available)  VALUES ('Tech Trio', 'Three of your favorite faces on individual vanilla cupcakes with colorful frosting. Pairs well with tears shed over leaving Tech Elevator. (Size: Cupcake)', 30.00, true);

COMMIT TRANSACTION;
