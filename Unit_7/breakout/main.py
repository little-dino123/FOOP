import pygame
import paddle
import ball
import brick

# RGB colors for pygame elements; google color picker
WHITE = (255, 255, 255)
PURPLE = (9, 66, 245)
BLACK = (0, 0, 0)
# globals
score = 0
lives = 3

pygame.init()
screen = pygame.display.set_mode((800, 600))
pygame.display.set_caption("Breakout Game")

all_sprites_list = pygame.sprite.Group()
all_bricks = pygame.sprite.Group()
for j in range(4):
    y = j*50+60
    for i in range(7):
        bricks1 = brick.Brick(PURPLE, 80, 30)
        bricks1.setxy((60 + i * 100), y)
        all_sprites_list.add(bricks1)
        all_bricks.add(bricks1)

paddle1 = paddle.Paddle(WHITE, 100, 10)
paddle1.setxy(350, 560)

ball1 = ball.Ball(WHITE, 10)
ball1.setxy(400, 540)

all_sprites_list.add(paddle1)
all_sprites_list.add(ball1)

playing = True

clock = pygame.time.Clock()
while playing:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            playing = False

    keys = pygame.key.get_pressed()
    movement_amount = 10
    if keys[pygame.K_LEFT]:
        paddle1.move(movement_amount, "left")
    elif keys[pygame.K_RIGHT]:
        paddle1.move(movement_amount, "right")

    # now right or you can use other keys too

    all_sprites_list.update()

    # bounce off sides
    if ball1.rect.x > 790 or ball1.rect.x < 10:
        ball1.velocity[0] = -ball1.velocity[0]
    if ball1.rect.y > 590:
        ball1.velocity[1] = -ball1.velocity[1]
        # went below paddle
        lives -= 1
        pygame.time.wait(3000)
        ball1.setxy(400, 540)
    if ball1.rect.y < 38:
        ball1.velocity[1] = -ball1.velocity[1]

    if pygame.sprite.collide_mask(ball1, paddle1):
        # depending on how bounce is made, update accordingly
        ball1.rect.x -= ball1.velocity[0]
        ball1.bounce()

    brick_collision_list = pygame.sprite.spritecollide(ball1, all_bricks, False)
    for bricks in brick_collision_list:
        ball1.bounce()
        bricks.kill()
        score += 1
        if len(brick_collision_list) == 0:
            playing = False
        # increase score
        # if no more bricks
        # playing=False

    screen.fill(BLACK)
    pygame.draw.line(screen, WHITE, [0, 38], [800, 38], 2)

    text = pygame.font.Font(None, 34).render("Score: " + str(score), 1, WHITE)
    screen.blit(text, (20, 10))

    text = pygame.font.Font(None, 34).render("Lives: " + str(lives), 1, WHITE)
    screen.blit(text, (650, 10))
    # now do lives
    if lives == 0:
        playing = False

    all_sprites_list.draw(screen)

    pygame.display.flip()

    clock.tick(60)

pygame.quit()
