// Post-processing: types module + standalone cell class declarations.
// These cells are registered via registerGuestType (not @ApiModule facades),
// so TSDoclet cannot scan them; the sync script appends this block.

declare module '@neomacros/types' {
    export const types: {
        Entity: typeof import('@neomacros/entity').Entity;
        // LocalPlayer is emitted as an interface (its base chain crosses
        // module blocks), so only the instance type is nameable here.
        LocalPlayer: import('@neomacros/player').LocalPlayer;
        Inventory: typeof import('@neomacros/player').Inventory;
        Vec3: Vec3Constructor;
        BlockPos: BlockPosConstructor;
        Block: BlockConstructor;
        BlockState: BlockStateConstructor;
        RayHit: RayHitConstructor;
    };
    // Only Vec3 stays a plain const: the generated part now declares the
    // BlockPos/Block/BlockState/RayHit classes themselves.
    export const Vec3: Vec3Constructor;
}

interface Vec3Constructor {
    new(x?: number, y?: number, z?: number): Vec3Instance;
    (x?: number, y?: number, z?: number): Vec3Instance;
}

interface BlockPosConstructor {
    new(x?: number, y?: number, z?: number): BlockPosInstance;
    (x?: number, y?: number, z?: number): BlockPosInstance;
}

interface BlockConstructor {
    new(pos: { x: number; y: number; z: number }): BlockInstance;
}

interface BlockStateConstructor {
    new(id: string, props?: Record<string, string>): BlockStateInstance;
}

interface RayHitConstructor {
    new(): RayHitInstance;
}

interface Vec3Instance {
    x: number; y: number; z: number;
    add(v: Vec3Instance): Vec3Instance;
    sub(v: Vec3Instance): Vec3Instance;
    mul(n: number): Vec3Instance;
    length(): number;
    lengthSq(): number;
    normalize(): Vec3Instance;
    distanceTo(v: Vec3Instance): number;
    dot(v: Vec3Instance): number;
    cross(v: Vec3Instance): Vec3Instance;
    lerp(v: Vec3Instance, t: number): Vec3Instance;
    withX(x: number): Vec3Instance;
    withY(y: number): Vec3Instance;
    withZ(z: number): Vec3Instance;
    floor(): BlockPosInstance;
    toJSON(): { x: number; y: number; z: number };
    toString(): string;
}

interface BlockPosInstance extends Vec3Instance {
    intX: number; intY: number; intZ: number;
    up(): BlockPosInstance;
    up(n: number): BlockPosInstance;
    down(): BlockPosInstance;
    down(n: number): BlockPosInstance;
    north(): BlockPosInstance;
    south(): BlockPosInstance;
    west(): BlockPosInstance;
    east(): BlockPosInstance;
    offset(dir: string, n: number): BlockPosInstance;
    center(): Vec3Instance;
}

interface BlockInstance {
    pos: { x: number; y: number; z: number };
    state: BlockStateInstance;
    valid: boolean;
}

interface BlockStateInstance {
    id: string;
    props: Record<string, string>;
    is(id: string): boolean;
}

interface RayHitInstance {
    block: BlockInstance | undefined;
    entity: import('@neomacros/entity').Entity | undefined;
    pos: { x: number; y: number; z: number };
    distance: number;
    hit: boolean;
}
