INSERT INTO `items_definitions` (`id`, `sprite`, `name`, `description`, `sprite_id`, `length`, `width`, `top_height`, `max_status`, `behaviour`, `interactor`, `is_tradable`, `is_recyclable`, `drink_ids`, `rental_time`, `allowed_rotations`) VALUES (2367, 'dark_merdragon', 'Black Leviathan', 'Limited Edition Rare. Found in the darkest depths of the abyss.', 4487, 1, 3, 0, '2', 'solid', 'default', 1, 1, '', -1, '0,2,4,6');

INSERT INTO `catalogue_items` (`id`, `sale_code`, `page_id`, `order_id`, `price_coins`, `price_pixels`, `hidden`, `amount`, `definition_id`, `item_specialspriteid`, `is_package`) VALUES (2348, 'dark_merdragon', '141', 2, 2, 0, 0, 1, 2367, '', 0);

UPDATE catalogue_items SET order_id = '0' WHERE sale_code = 'dark_merdragon';

